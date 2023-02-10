package Model;

import android.util.Log;

public class User {

    private int id,retree_ok;
    private String concours, choix_concours, num_cdd, nom_cdd, prenom_cdd, genre_cdd, naissance_cdd, lieu_cdd, tel_cdd, resid_cdd, adress_cdd, typebac_cdd, annbac_cdd, valide, motif, centre_exam, salle, date_retree, token;

    public User() {
    }

    public User(String token) {
        this.token = token;
    }


    public User(int id, String concours, String choix_concours, String num_cdd, String nom_cdd, String prenom_cdd, String genre_cdd, String naissance_cdd, String lieu_cdd, String tel_cdd, String resid_cdd, String adress_cdd, String typebac_cdd, String annbac_cdd, String valide, String motif, String centre_exam, String salle, String date_retree, int retree_ok, String token) {
        this.id = id;
        this.concours = concours;
        this.choix_concours = choix_concours;
        this.num_cdd = num_cdd;
        this.nom_cdd = nom_cdd;
        this.prenom_cdd = prenom_cdd;
        this.genre_cdd = genre_cdd;
        this.naissance_cdd = naissance_cdd;
        this.lieu_cdd = lieu_cdd;
        this.tel_cdd = tel_cdd;
        this.resid_cdd = resid_cdd;
        this.adress_cdd = adress_cdd;
        this.typebac_cdd = typebac_cdd;
        this.annbac_cdd = annbac_cdd;
        this.valide = valide;
        this.motif = motif;
        this.centre_exam = centre_exam;
        this.salle = salle;
        this.date_retree = date_retree;
        this.retree_ok = retree_ok;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcours() {
        return concours;
    }

    public void setConcours(String concours) {
        this.concours = concours;
    }

    public String getChoix_concours() {
        return choix_concours;
    }

    public void setChoix_concours(String choix_concours) {
        this.choix_concours = choix_concours;
    }

    public String getNum_cdd() {
        return num_cdd;
    }

    public void setNum_cdd(String num_cdd) {
        this.num_cdd = num_cdd;
    }

    public String getNom_cdd() {
        return nom_cdd;
    }

    public void setNom_cdd(String nom_cdd) {
        this.nom_cdd = nom_cdd;
    }

    public String getPrenom_cdd() {
        return prenom_cdd;
    }

    public void setPrenom_cdd(String prenom_cdd) {
        this.prenom_cdd = prenom_cdd;
    }

    public String getGenre_cdd() {
        return genre_cdd;
    }

    public void setGenre_cdd(String genre_cdd) {
        this.genre_cdd = genre_cdd;
    }

    public String getNaissance_cdd() {
        return naissance_cdd;
    }

    public void setNaissance_cdd(String naissance_cdd) {
        this.naissance_cdd = naissance_cdd;
    }

    public String getLieu_cdd() {
        return lieu_cdd;
    }

    public void setLieu_cdd(String lieu_cdd) {
        this.lieu_cdd = lieu_cdd;
    }

    public String getTel_cdd() {
        return tel_cdd;
    }

    public void setTel_cdd(String tel_cdd) {
        this.tel_cdd = tel_cdd;
    }

    public String getResid_cdd() {
        return resid_cdd;
    }

    public void setResid_cdd(String resid_cdd) {
        this.resid_cdd = resid_cdd;
    }

    public String getAdress_cdd() {
        return adress_cdd;
    }

    public void setAdress_cdd(String adress_cdd) {
        this.adress_cdd = adress_cdd;
    }

    public String getTypebac_cdd() {
        return typebac_cdd;
    }

    public void setTypebac_cdd(String typebac_cdd) {
        this.typebac_cdd = typebac_cdd;
    }

    public String getAnnbac_cdd() {
        return annbac_cdd;
    }

    public void setAnnbac_cdd(String annbac_cdd) {
        this.annbac_cdd = annbac_cdd;
    }

    public String getValide() {
        return valide;
    }

    public void setValide(String valide) {
        this.valide = valide;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getCentre_exam() {
        return centre_exam;
    }

    public void setCentre_exam(String centre_exam) {
        this.centre_exam = centre_exam;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public String getDate_retree() {
        return date_retree;
    }

    public void setDate_retree(String date_retree) {
        this.date_retree = date_retree;
    }

    public int getRetree_ok() {
        return retree_ok;
    }

    public void setRetree_ok(int retree_ok) {
        this.retree_ok = retree_ok;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}