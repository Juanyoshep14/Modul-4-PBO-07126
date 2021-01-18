package Entity;

public class daftarpembeli {
    private PembeliEntity pembeli;
    private boolean isVerified;
    private int indexGame;

    public daftarpembeli(PembeliEntity pembeli, boolean isVerified, int indexGame) {
        this.pembeli = pembeli;
        this.isVerified = isVerified;
        this.indexGame = indexGame;
    }

    public PembeliEntity getPembeli() {
        return pembeli;
    }

    public void setPembeli(PembeliEntity pembeli) {
        this.pembeli = pembeli;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public int getIndexGame() {
        return indexGame;
    }

    public void setIndexGame(int indexGame) {
        this.indexGame = indexGame;
    }

}
