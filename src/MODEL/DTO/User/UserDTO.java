/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL.DTO.User;

/**
 *
 * @author mahallawy
 */
public class UserDTO {
    private int id;
    private String password;
    private String email;
    private String firstname;
    private Integer addressId;
    private String mobilePhone;
    private Integer roleId;
    private Integer status;
    private RoleDTO role;


    public UserDTO() {}

    public UserDTO(int id) {
        this.id = id;
    }

    public UserDTO(String email, String password) {
        this.password = password;
        this.email = email;
    }
    
    //----------------------------------------------------
    public UserDTO(RoleDTO role) {
            this.role = role;

    }
        public RoleDTO getRole() {
        return this.role;
    }
    public void setRole(RoleDTO role) {
        this.role = role;
        if (role != null) {
            this.roleId = role.getId();  // Sync the roleId with the role object
        }
    }
    public UserDTO(int id, String password, String email, String firstname, Integer addressId, 
                   String mobilePhone, Integer roleId, Integer status, RoleDTO role) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.addressId = addressId;
        this.mobilePhone = mobilePhone;
        this.roleId = roleId;
        this.status = status;
        this.role = role;
    }
  //-------------------------------------------      
      
    public UserDTO(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public UserDTO(int i, String admin123, String adminmailcom, String admin_User, Object object, String string, int i0, int i1) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public Integer getAddressId() { return addressId; }
    public void setAddressId(Integer addressId) { this.addressId = addressId; }

    public String getMobilePhone() { return mobilePhone; }
    public void setMobilePhone(String mobilePhone) { this.mobilePhone = mobilePhone; }

    public Integer getRoleId() { return roleId; }
    public void setRoleId(Integer roleId) { this.roleId = roleId; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
}
