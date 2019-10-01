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

public class Grafico extends JFrame{
	
	private JPanel panel;
	
	public Grafico() throws ComplexException{
        setTitle("Vector de estado final");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        init();
    }
 
    private void init() throws ComplexException {
        panel = new JPanel();
        getContentPane().add(panel);
        
        // Fuente de Datos
        MatrizCompleja vectorFinal;

		vectorFinal = Rendija.obtenerVectorFinal();		
        
        
        DefaultPieDataset data = new DefaultPieDataset();
        
        for (int i = 0; i < vectorFinal.getMatriz().length; i++) {
        	String estado = Integer.toString(i);
        	
        	
        	DecimalFormat df = new DecimalFormat("#.00");
        	
        	String s = df.format(vectorFinal.getMatriz()[i][0].getParteReal() * 100);

        	estado = "Estado " + estado + " = " + s + "%";
			data.setValue(estado, vectorFinal.getMatriz()[i][0].getParteReal());
		}

 
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart("Vector de estado final del experimento de las rendijas:", data, true, true, false);
 
        // Crear el Panel del Grafico con ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }
    
}
