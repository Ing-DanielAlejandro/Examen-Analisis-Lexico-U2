package Jflextest;

import java.io.*;

import javax.swing.JOptionPane;

public class TestClass {

	public static void main(String args[]) throws IOException {

		// String str = JOptionPane.showInputDialog("expresión");
		int n = 0,t = 0,c = 0,m = 0,v = 0,em = 0;
		String str = null;

		FileReader fr;
		BufferedReader br;
		String ruta = "C:\\Users\\el-at\\eclipse-workspace\\Examen Analisis Lexico U2\\archivo.txt";
		String ruta2 = "C:\\Users\\el-at\\eclipse-workspace\\Examen Analisis Lexico U2\\Contactos.html";
		File file = new File(ruta);

		File f;
		FileWriter w;
		BufferedWriter bw;
		PrintWriter wr;

		try {

			f = new File(ruta2);
			w = new FileWriter(f);
			bw = new BufferedWriter(w);
			wr = new PrintWriter(bw);

			wr.write("<!DOCTYPE html>");
			wr.append("<head><h1>Examen JFlex</h1>");
			wr.append("</head><body><h2>Daniel Alejandro Martinez Gomez<h2>");

			// Si el archivo no existe es creado
			if (!file.exists()) {
				file.createNewFile();
			} else {

				fr = new FileReader(file);
				br = new BufferedReader(fr);
				String temp, bfRead = "";

				String resultados = "";

				while ((str = br.readLine()) != null) {
					
					InputStream is = new ByteArrayInputStream(str.getBytes());
					NewLexer lexer = new NewLexer(is);
					wr.append("<br/>");
					while (true) {
						Token token = lexer.yylex();
						if (token == null) {
							// resultados += "FIN";
							break;
						}

						// igual, suma, variable, numero, multiplicacion, resta, division, ERROR
						switch (token) {
						case White:
							wr.append("<b>&nbsp;</b>");
							break;
						case ERROR:
							resultados += "< ERROR, " + lexer.lexeme + " >\n";
							break;
						case Tellocal:
							t++;
							wr.append("<b style=\"color:green\";>" + lexer.lexeme + "</b>");
							break;
						case Celular:
							c++;
							wr.append("<b style=\"color:red\";>" + lexer.lexeme + "</b>");
							break;
						case Email:
							em++;
							wr.append("<a href=\"mailto:elcorreoquequieres@correo.com\">" + lexer.lexeme + "</a>");
							break;
						case Mastercard:
							m++;
							wr.append("<b style=\"color:blue\";>" + lexer.lexeme + "</b>");
							break;
						case Visa:
							v++;
							wr.append("<b style=\"color:purple\";>" + lexer.lexeme + "</b>");
							break;
						case Nombre:
							n++;
							wr.append("<b>" + lexer.lexeme + "\n</b>");
							break;
						default:
							resultados += "Token: " + token + " \n";
							break;
						}
					}

				}

				wr.append("</body> </html>");
				wr.close();
				bw.close();
				JOptionPane.showMessageDialog(null, "Estos son la cantidad datos que se encontraron:\n"
						+ "Nombres: "+n+
						"\nTelefonos: "+t+
						"\nCelulares: "+c+
						"\nEmails: "+em+
						"\nMastercard: "+m+
						"\nVisa: "+v);
					
			}

		} catch (Exception e) {
			System.err.println("No se pudo crear el archivo");
		}

	}

}
