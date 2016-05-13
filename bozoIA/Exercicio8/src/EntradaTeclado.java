import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class EntradaTeclado {
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);

    public static String leString() throws IOException {
        String x;
        x = br.readLine();
        return x;
    }

    public static int leInt() throws IOException {
        String x = leString();
        return Integer.parseInt(x);
    }

    public static double leDouble() throws IOException {
        String x = leString();
        return Double.parseDouble(x);
    }
    
    public static float leFloat() throws IOException {
        String x = leString();
        return Float.parseFloat(x); 
    }
}
