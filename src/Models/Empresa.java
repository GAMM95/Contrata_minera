package Models;

public class Empresa {

    //  Atributos de la clase
    private int codEmpresa;
    private String ruc;
    private String razonSocial;
    private String ciiu;
    private String telefono;
    private String celular;
    private String direccionLegal;
    private String email;
    private String paginaWeb;
    private byte[] logo;
    private String path;    // ruta de la foto

    //  Constructor vacio
    public Empresa() {
    }

    //  Sobrecarga del constructor
    public Empresa(int codEmpresa, String ruc, String razonSocial, String ciiu, String telefono, String celular, String direccionLegal, String email, String paginaWeb, byte[] logo, String path) {
        this.codEmpresa = codEmpresa;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.ciiu = ciiu;
        this.telefono = telefono;
        this.celular = celular;
        this.direccionLegal = direccionLegal;
        this.email = email;
        this.paginaWeb = paginaWeb;
        this.logo = logo;
        this.path = path;
    }

    public Empresa(String ruc, String razonSocial, String ciiu, String telefono, String celular, String direccionLegal, String email, String paginaWeb, byte[] logo, String path) {
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.ciiu = ciiu;
        this.telefono = telefono;
        this.celular = celular;
        this.direccionLegal = direccionLegal;
        this.email = email;
        this.paginaWeb = paginaWeb;
        this.logo = logo;
        this.path = path;
    }

    public Empresa(String ruc, String razonSocial, String ciiu, String telefono, String celular, String direccionLegal, String email, String paginaWeb, String path) {
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.ciiu = ciiu;
        this.telefono = telefono;
        this.celular = celular;
        this.direccionLegal = direccionLegal;
        this.email = email;
        this.paginaWeb = paginaWeb;
        this.path = path;
    }

    //  Metodos Getter and Setter
    public int getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(int codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCiiu() {
        return ciiu;
    }

    public void setCiiu(String ciiu) {
        this.ciiu = ciiu;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccionLegal() {
        return direccionLegal;
    }

    public void setDireccionLegal(String direccionLegal) {
        this.direccionLegal = direccionLegal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
