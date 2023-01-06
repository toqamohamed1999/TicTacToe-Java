/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Eman
 */
public class Client {
   private int id ; 
   private String userName;
   private String email ; 
   private String password ;
   private String gender;
   private int score ; 
   private String recordsPath ; 

    public Client() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setRecordsPath(String recordsPath) {
        this.recordsPath = recordsPath;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String gender() {
        return gender;
    }

    public int getScore() {
        return score;
    }

    public String getRecordsPath() {
        return recordsPath;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password + ", gender=" + gender + ", score=" + score + ", recordsPath=" + recordsPath + '}';
    }
   
   
   
    
}
