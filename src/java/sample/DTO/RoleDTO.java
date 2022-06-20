/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.DTO;

/**
 *
 * @author Admin
 */
public class RoleDTO {

    private int roleID;
    private String rolelName;

    public RoleDTO() {
    }

    public RoleDTO(int roleID, String rolelName) {
        this.roleID = roleID;
        this.rolelName = rolelName;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRolelName() {
        return rolelName;
    }

    public void setRolelName(String rolelName) {
        this.rolelName = rolelName;
    }

}
