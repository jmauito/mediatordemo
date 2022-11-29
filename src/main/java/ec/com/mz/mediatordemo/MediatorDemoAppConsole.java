package ec.com.mz.mediatordemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MediatorDemoAppConsole {

    private Procedure procedure;

    private Procedure createGradautionProcedure(){
        Procedure procedure = new Procedure();

        Task taskA = new TaskA(procedure,TaskStatus.EN_PROGRESO,1);
        Task taskB = new TaskB(procedure,TaskStatus.EN_PROGRESO,2);
        Task taskC = new TaskC(procedure,TaskStatus.EN_PROGRESO,3);
        Task taskD = new TaskD(procedure,TaskStatus.EN_PROGRESO,4);

        List<Task> tasks = new ArrayList<Task>();
        tasks.add(taskA);
        tasks.add(taskB);
        tasks.add(taskC);
        tasks.add(taskD);

        procedure.addTasks(tasks);

        return procedure;
    }

    public static void main(String[] args) {
        MediatorDemoAppConsole app = new MediatorDemoAppConsole();
        Scanner scanner = new Scanner(System.in);
        String response = "";

        System.out.print( "Inicializando el trámite... " );
        app.procedure = app.createGradautionProcedure();
        System.out.println("Trámite creado");

        while (!"x".equals(response)){
            System.out.println("Desea ejecutar su trámite de titulación? s/n (x para salir)");
            response = scanner.nextLine();
            if( "s".equals(response)){

                System.out.println("Solicitanto ejecución");
                app.procedure.execute();
            }
        }
        System.out.println("Gracias. Vuelva pronto");

    }

}
