import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MegaSena {

    public static void main(String[] args) {

        List<Integer> apostaMega = new ArrayList<>();

        for(int a = 0; a < 6; a++){
            apostaMega.add(Integer.valueOf(JOptionPane.showInputDialog("Digite a sua aposta com os numeros ordenados")));
        }
        Collections.sort(apostaMega);

        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i < 60; i++) {
            numeros.add(i);
        }
        Collections.shuffle(numeros);
        List<Integer> cartaoGerado = numeros.subList(0,6);
        Collections.sort(cartaoGerado);

        contaAcertos( apostaMega,cartaoGerado);
        System.out.print("Sua Aposta: "+apostaMega + " ");
        System.out.println(" ");
        System.out.println("Cartao Gerado: "+cartaoGerado +" ");

    }

    public static void contaAcertos(List<Integer> apostaMega, List<Integer> cartaoGerado) {
        int acertos = 0;
        for (int i = 0; i < cartaoGerado.size(); i++) {
            Integer nroAposta = apostaMega.get(i);

            if (existeNumero(cartaoGerado, nroAposta)) {
                acertos++;
            }
        }
        verificaPremio(acertos);
    }


    public static boolean existeNumero(List<Integer> numeros, Integer n) {
        for (int i = 0; i < numeros.size()-1; i++) {
            if (numeros.get(i) == n) {
                return true;
            }
        }
        return false;
    }

    public static void verificaPremio(int contador) {
        if (contador==6){
            System.out.println("Parabens voce ganhou a Mega Sena, voce teve "+contador+" acertos!");
        }else if(contador==5){
            System.out.println("Parabens voce ganhor a Quina, voce teve "+contador+" acertos!");
        }else if (contador == 4){
            System.out.println("Parabens voce ganhor a Quadra, voce teve "+contador+" acertos!");
        }else{
            System.out.println("Infelizmente voce nao ganhou nada, tente novamente...., voce teve "+contador+" acertos!");
        }
    }

}
