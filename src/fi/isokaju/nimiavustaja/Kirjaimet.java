/**
 * 
 */
package fi.isokaju.nimiavustaja;

/**
 * @author Jussi
 *
 */

public class Kirjaimet extends Thread {

	private String[] aakkoset;
	private Nimiavustaja window;
	private volatile boolean interrupted = false;
	private String currentChar;

	public Kirjaimet(String[] aakkoset, Nimiavustaja nimiavustaja) {
		this.aakkoset = aakkoset;
		this.window = nimiavustaja;

		/// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override

	public void run() {

		try {
			Thread.sleep(2000);
			while (!Thread.currentThread().isInterrupted()) {
				for (int i = 0; i < aakkoset.length; i++) {
					Thread.sleep(3000);
					if (this.interrupted) {
						Thread.sleep(100);
						this.interrupted = false;
						i = 0;
					}
					window.tulosta(aakkoset[i]);
					this.currentChar = aakkoset[i];
				}

			}

		} catch (InterruptedException e) {
			// Thread.currentThread().interrupt(); // restore interrupted status
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

	public void interruped() {

		this.interrupted = true;
		window.BuildWord(currentChar);

	}

}
