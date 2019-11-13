package complexLibrary.dinamicas;

import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import complexLibrary.matricesComplejas.MatrizCompleja;

public class Grafico extends JFrame {

    private final MatrizCompleja vectorFinal;

    public Grafico(MatrizCompleja vectorFinal) {
        setTitle("Vector de estado final");
        setSize(1500, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        this.vectorFinal = vectorFinal;
        init("R");
    }

    public Grafico(MatrizCompleja vectorFinal, boolean algoritmoDeDeutsch) {
        setTitle("Algoritmo de Deutsch");
        setSize(1500, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        this.vectorFinal = vectorFinal;
        init("D");
    }

    private void init(String x) {
        String titulo = "";
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        // Fuente de Datos
        DefaultPieDataset data = new DefaultPieDataset();

        for (int i = 0; i < vectorFinal.getMatriz().length; i++) {
            String estado = Integer.toString(i);



            DecimalFormat df = new DecimalFormat("#.00");
            double valor = vectorFinal.getMatriz()[i][0].getParteReal();

            String a;
            if (valor < 1) {
                a = "0" + df.format(vectorFinal.getMatriz()[i][0].getParteReal());
            } else {
                a = df.format(vectorFinal.getMatriz()[i][0].getParteReal());
            }

            if(x.equals("D")){
                //String[] qubits = {"00", "01", "10", "11"};
                String estadoEnBinario = Integer.toBinaryString(Integer.parseInt(estado));
                if(estadoEnBinario.length() == 1){
                    estadoEnBinario = "0" + estadoEnBinario;
                }
                estado = estadoEnBinario + " = " + a + "%";

                //estado = qubits[i] + " = " + a + "%";
                titulo = "Algoritmo de Deutsch:";
            }else if(x.equals("R")){
                estado = "Estado " + estado + " = " + a + "%";
                titulo = "Vector de estado final:";
            }


            data.setValue(estado, vectorFinal.getMatriz()[i][0].getParteReal() * 100);
        }

        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(titulo, data, true, true, false);

        // Crear el Panel del Grafico con ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }

}
