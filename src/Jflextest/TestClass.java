package Jflextest;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TestClass {

	public static void main(String args[]) throws IOException {

		int n = 0, t = 0, c = 0, m = 0, v = 0, em = 0;
		String str = null;

		String dirTexto = "C:\\Users\\el-at\\eclipse-workspace\\Examen Analisis Lexico U2\\archivo.txt";
		String dirHtml = "C:\\Users\\el-at\\eclipse-workspace\\Examen Analisis Lexico U2\\Contactos.html";

		File html = new File(dirHtml);
		File texto = new File(dirTexto);

		FileWriter w = new FileWriter(html);
		BufferedWriter bw = new BufferedWriter(w);
		PrintWriter wr = new PrintWriter(bw);

		try {
			FileReader fr = new FileReader(texto);
			BufferedReader br = new BufferedReader(fr);

			// Si el archivo no existe es creado
			if (!texto.exists()) {
				texto.createNewFile();

			} else {

				wr.write("<!DOCTYPE html>\n");
				wr.append("<html lang='es'><head></head>\n");
				wr.append("<body><h1>Examen JFlex</h1>" + "<h2>Daniel Alejandro Martinez Gomez</h2>\n");

				String temp, bfRead = "";
				String resultados = "";

				while ((str = br.readLine()) != null) {

					InputStream is = new ByteArrayInputStream(str.getBytes());
					NewLexer lexer = new NewLexer(is);

					while (true) {
						Token token = lexer.yylex();
						if (token == null) {
							// resultados += "FIN";
							break;
						}

						switch (token) {

						case White:
							wr.append("&nbsp;");
							break;
						case Tab:
							wr.append(" &nbsp;&nbsp;&nbsp;");
							break;
						case ERROR:
							wr.append(lexer.lexeme);
							break;
						case Tellocal:
							t++;
							wr.append("<b style='color:green';>" + lexer.lexeme + "</b>\n");
							break;
						case Celular:
							c++;
							wr.append("<b style='color:red';>" + lexer.lexeme + "</b>\n");
							break;
						case Email:
							em++;
							wr.append("<a href='mailto:" + lexer.lexeme + "'>" + lexer.lexeme + "</a> \n");
							break;
						case Mastercard:
							m++;
							wr.append("<b style='color:blue';>" + lexer.lexeme + "</b>\n");
							break;
						case Visa:
							v++;
							wr.append("<b style='color:purple';>" + lexer.lexeme + "</b>\n");
							break;
						case Nombre:
							n++;
							wr.append("<strong>" + lexer.lexeme + "</strong>\n");
							break;
						default:
							// resultados += "Token: " + token + " \n";
							break;
						}
					}
					wr.append("<br/>");
				}
				wr.append("&nbsp;&nbsp;<p>Estadisticas</p>\n");

				wr.append("<b>&nbsp;&nbsp;Nombres: " + n + "</b><br/>\n");
				wr.append("<b style='color:green';>&nbsp;&nbsp;Telefonos: " + t + "</b><br/>\n");
				wr.append("<b style='color:red';>&nbsp;&nbsp;Celulares: " + c + "</b><br/>\n");
				wr.append("<b style='color:blue';>&nbsp;&nbsp;Email: " + em + "</b><br/>\n");
				wr.append("<b style='color:blue';>&nbsp;&nbsp;MasterCard: " + m + "</b><br/>\n");
				wr.append("<b style='color:purple';>&nbsp;&nbsp;Visa: " + v + "</b><br/>\n");
				wr.append("</body> </html>");
				wr.close();
				bw.close();

			}

		} catch (Exception e) {
			System.err.println("No se pudo crear el archivo");
			e.printStackTrace();
		}

	}

}
