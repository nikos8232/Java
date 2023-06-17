/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.it2021078.Model.Accounts;

import java.util.ArrayList;

/**
 *
 * @author nik
 */
public class Accounts {


        static int count= 0;
        protected  int accountId;
        protected String username;
        protected String password;
        protected String email;

        public Accounts(String email, String username, String password){

            this.email = email;
            this.username = username;
            this.password = password;
            this.accountId = ++this.count;
        }

        // Getter
        public int getAccountId() {
          return accountId;
        }

        // Setter
        public void setAccountId(int newAccountId) {
          this.accountId = newAccountId;
        }    
        
        
         // Getter
        public String getUsername() {
          return username;
        }

        // Setter
        public void setUsername(String newUsername) {
          this.username = newUsername;
        }    
        
         // Getter
        public String getPassword() {
          return password;
        }

        // Setter
        public void setPassword(String newPassword) {
          this.password = newPassword;
        }    
        
        
}
