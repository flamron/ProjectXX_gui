package by.pvt.service;

import by.pvt.dto.AppUserDto;
import by.pvt.pojo.AppRole;
import by.pvt.pojo.AppUser;
import by.pvt.pojo.RoleName;
import by.pvt.repository.AppRoleRepository;
import by.pvt.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class UserService {

    private static Logger log = Logger.getLogger("UserService");

    @Autowired
    AppRoleRepository roleRepository;

    @Autowired
    AppUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public boolean saveUser(AppUser user) {
        if (user == null || user.getFirstName().isEmpty() || user.getLastName().isEmpty()
        || user.getEmail().isEmpty() || user.getPassword().isEmpty() ||
        userRepository.findUserByEmail(user.getEmail()) != null) {
            return false;
        }
        AppRole userRole = roleRepository.findByRoleName(RoleName.USER);
        if (userRole == null) {
            userRole = new AppRole();
            userRole.setRoleName(RoleName.USER);
            roleRepository.save(userRole);
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        log.info("Encoded password" + encodedPassword);
        user.setPassword(encodedPassword);
        user.setAppRoles(Set.of(userRole));
        userRepository.save(user);
        return true;
    }

    @Transactional
    public List<AppUserDto> getAllUsersDto() {
        List<AppUser> users = userRepository.getAllUsers();
        List<AppUserDto> dtoList = new ArrayList<>(users.size());
        for (AppUser user : users) {
            AppUserDto dto = AppUserDto.builder()
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .appRoles(new HashSet<>(user.getAppRoles()))
                    .build();
            dtoList.add(dto);
        }
        return dtoList;
    }

}
















