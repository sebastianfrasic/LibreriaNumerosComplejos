package complexLibrary.dinamicas;

import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.MatrizCompleja;

public class Grafico extends JFrame {

    private JPanel panel;
    private final MatrizCompleja vectorFinal;

    public Grafico(MatrizCompleja vectorFinal) throws ComplexException {
        setTitle("Vector de estado final");
        setSize(1500, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        this.vectorFinal = vectorFinal;
        init();
    }

    private void init() {
        panel = new JPanel();
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

            estado = "Estado " + estado + " = " + a + "%";
            data.setValue(estado, vectorFinal.getMatriz()[i][0].getParteReal() * 100);
        }

        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart("Vector de estado final:", data, true, true, false);

        // Crear el Panel del Grafico con ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }

}
