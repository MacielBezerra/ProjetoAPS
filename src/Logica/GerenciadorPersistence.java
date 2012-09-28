package Logica;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Modelo.Persistence;
public class GerenciadorPersistence {

	public void persistir() {

		FileOutputStream fos = null;
		ObjectOutputStream stream = null;

		try {
			fos = new FileOutputStream("dados.bin");
			stream = new ObjectOutputStream(fos);
			stream.writeObject(Persistence.getInstance());//escrita do Objeto Pesistence onde se encontram todas minhas listas

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void recuperar() {

		FileInputStream fis = null;
		ObjectInputStream stream = null;

		try {

			fis = new FileInputStream("dados.bin");
			stream = new ObjectInputStream(fis);
			Persistence.setInstance((Persistence) stream.readObject());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}