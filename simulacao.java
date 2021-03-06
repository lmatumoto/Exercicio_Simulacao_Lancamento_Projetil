
import java.util.Scanner;


public class Main {

 
    // conversão em radianos
    public static double converterRad (double ang){ 
         double ang_rad =  Math.toRadians(ang); 
         return (ang_rad);
        
    }
    // conversão seno
    public static double converterSen(double ang){
          double ang_rad =  Math.toRadians(ang);
          double ang_sen = Math.sin(ang_rad); // seno
          return (ang_sen);
        
    }
    // conversão cosseno
     public static double converterCos(double ang){
          double ang_rad =  Math.toRadians(ang);
          double ang_cos = Math.cos(ang_rad); // cosseno
          return (ang_cos);
        
    }
    // exibir resultado
    public static void exibirResultado(double alcHoz, double fin_alv, double com_alv){
        System.out.println("\t == Resultado == \n");
        
        if((alcHoz >= com_alv) && (alcHoz <= fin_alv)){
            System.out.println("Você acertou o alvo! Parabéns! ");
        }else if (alcHoz < com_alv){
            System.out.println("Projétil caiu antes do alvo. Tente novamente. ");
        }else{
            System.out.println("Projétil caiu depois do alvo. Tente novamente.");    
        }
        
    }
      // exibir dados finais
    public static void exibirDados (double altMax, double temp, double alcHoz){
        System.out.printf("\nAltura Máxima: " + altMax + " metros");
        System.out.println("\nTempo: " + temp + " segundos");
        System.out.println("Alcance Horizontal: " + alcHoz + " metros");
    }
    
    public static void main(String[] args) {
  Scanner entrada = new Scanner (System.in);
  
       
        System.out.println("\t== Lançamento de Projétil ==\n");
        double ang; // ângulo
        double vel; // velocidade
        double dis; // distância
        double tam; // tamanho do alvo
        double acel = 9.81; // aceleração
       
        // Usuário digita o ângulo
        do{
        System.out.println("Digite o ângulo (em graus): ");
         ang = entrada.nextDouble();
         
        }while(ang <=0 || ang >= 90);
        
        converterRad(ang);
        converterSen(ang);
        converterCos(ang);
       
       
        /*Teste de Conversão
        System.out.println(ang);
        System.out.println(converterRad(ang));
        System.out.println(converterSen(ang));
        System.out.println(converterCos(ang));
       */
        
        // Usuário digita a velocidade inicial
        do{
        System.out.println("Digite a velocidade inicial do projétil:");
        vel = entrada.nextDouble();
    
        }while(vel <= 0);
        
        double altMax = ((Math.pow(vel, 2))*(Math.pow(converterSen(ang), 2)) / (2 * acel)); // altura máxima
        double temp = ((2 * vel * converterSen(ang)) / acel); // tempo
        double alcHoz =  ( 2 * (Math.pow(vel, 2)) *((converterCos(ang) * converterSen(ang))/ acel)); // alcance horizontal
        
        // Usuário digita a distância do alvo
        do{
            System.out.println("Digite a distância do alvo: ");
            dis = entrada.nextDouble();
               
        }while(dis <= 0);
        
        // Usuário digita o tamanho do alvo
        do{
            System.out.println("Digite o tamanho do alvo: (Entre 20 e 50 metros)");
            tam = entrada.nextDouble();  
        }while(tam < 20 || tam > 50);
        
        double com_alv = dis - (tam/2); // início do alvo
        double fin_alv = dis + (tam/2); // final do alvo
        
        exibirResultado(alcHoz, fin_alv,com_alv); // exibe resultado
        exibirDados(altMax,temp, alcHoz); // exibe dados
              
   }  
}
