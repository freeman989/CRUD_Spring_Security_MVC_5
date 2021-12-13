package data.dao;
import data.model.Role;

public interface RoleDAO {
    void save(Role role);
    void delete(Role role);
    Role getById(Long id);
    Role getRoleByName(String role);
    Role createRoleIfNotFound(String name, long id);
}
