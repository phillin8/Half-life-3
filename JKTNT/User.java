import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {
    private String userName;
    private int role;
    
    public User(String user) {
        userName = user;
    }
    /*
     * Can look up role of any user.
     */
    public boolean isUser(final String userN) {
       return searchFile(userN, 0);
    }
    public boolean isAdmin(final String userN) {
       return searchFile(userN, 2);
    }
    public boolean isMod(final String userN) {
       return searchFile(userN, 1);
    }
    /*
     * This method is super jank and could totally be written better
     */
    /*public void setRole(final String userN, final int num) throws FileNotFoundException{
       if (isAdmin(this.userName)) {
           try {
               File users = new File("userlogin.csv");
               Scanner read = new Scanner(users);
               String[] lines = null;
               for (int i = 0; read.hasNextLine(); i++) {
                   lines[i] = read.nextLine();
                   int pos = lines[i].indexOf(",");
                   String user = lines[i].substring(0, pos);
                   if (user == userN) {
                       lines[i] = lines[i].substring(0, lines[i].length() - 1) + num;
                   }
               }
               FileWriter write = new FileWriter(users);
               
               
           } catch (FileNotFoundException e) {
               System.out.println("Cannot find file!");
               e.printStackTrace();
           }
       } else {
           System.out.println("Not permitted!");
       }
    }*/
    private boolean searchFile(String userN, int num) {
        try {
            File users = new File("userlogin.csv");
            Scanner reader = new Scanner(users);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                int pos = data.indexOf(",");
                String user = data.substring(0, pos);
                int pos2 = data.indexOf(",", pos + 1);
                String pass = data.substring(pos + 1, pos2);
                int role = Integer.parseInt(data.substring(pos2 + 1, data.length()));
                if (!user.isEmpty() && !pass.isEmpty() && user.equals(userN) && role == num) {
                    reader.close();
                    return true;
                }
            }
            reader.close();
            return false;
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file!");
            e.printStackTrace();
            return false;
        }
    }
    public boolean searchFile(String userN, String passW) {
        try {
            File users = new File("userlogin.csv");
            Scanner reader = new Scanner(users);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                int pos = data.indexOf(",");
                String user = data.substring(0, pos);
                int pos1 = data.indexOf(",", pos + 1);
                String pass = data.substring(pos + 1, pos1);
                if (!user.isEmpty() && !pass.isEmpty() && user.equals(userN) && pass.equals(passW)) {
                    reader.close();
                    return true;
                }
            }
            reader.close();
            return false;
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file!");
            e.printStackTrace();
            return false;
        }
    }
    /*
     * Attempts to login the user by referencing the csv file containing
     * user login information. If good returns true, otherwise false.
     * 
     * @param userN - The user name read in from the text field
     * 
     * @param passW - The password read in from the text field
     */
    public boolean loginUser(final String userN, final String passW) {
        final boolean goodReg = searchFile(userN, passW);
        if (goodReg) {
            setUserName(userN);
        }
        return goodReg;
    }
    /*
     * Simply sets the current user to blank and therefore logs the user out.
     */
    public boolean logout() {
        if (this.userName.isEmpty()) {
            return false;
        } else {
            setUserName("");
            return true;
        }
    }
    /*
     * Returns true if the user was registered, returns false if the user was not.
     * User would only not be registered if the user name is already taken.
     * 
     * Checking for an empty string or acceptable characters should happen where this
     * method is being called.
     */
    public boolean registerUser(String userN, String passW) {
        boolean goodReg = searchFile(userN, passW);
        if (!goodReg) {
            try {
                File users = new File("userlogin.csv");
                FileWriter write = new FileWriter(users, true);
                write.append(userN + "," + passW + ",0\n");
                write.close();
                setUserName(userN);
            } catch (IOException e){
                System.out.println("File not found!");
                e.printStackTrace();
            }
        }
        return !goodReg;

    }
    public String getUserName() {
        return userName;
    }
    private void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the role
     */
    public int getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    private void setRole(int role) {
        this.role = role;
    }
}
