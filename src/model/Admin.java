/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author shrey
 */
public class Admin{
    
    private final String adminRole;
    private final String adminUserName;
    private final String adminPassWord;
    
    public Admin(String adminRole, String adminUserName, String adminPassWord)
    {
        this.adminRole = adminRole;
        this.adminUserName = adminUserName;
        this.adminPassWord = adminPassWord;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public String getAdminPassWord() {
        return adminPassWord;
    }
    
}
