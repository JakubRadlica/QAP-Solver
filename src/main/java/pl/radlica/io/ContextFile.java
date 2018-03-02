package pl.radlica.io;

public enum ContextFile {
    QNP_12("context/had12.dat"),
    QNP_14("context/had14.dat"),
    QNP_16("context/had16.dat"),
    QNP_18("context/had18.dat"),
    QNP_20("context/had20.dat");

    private final String file;

    ContextFile(final String file){
        this.file=file;
    }

    public String getFileName(){
        return this.file;
    }
}
