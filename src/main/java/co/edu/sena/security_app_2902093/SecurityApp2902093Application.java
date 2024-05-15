package co.edu.sena.security_app_2902093;

import co.edu.sena.security_app_2902093.persistence.entity.PermissionEntity;
import co.edu.sena.security_app_2902093.persistence.entity.RoleEntity;
import co.edu.sena.security_app_2902093.persistence.entity.RoleEnum;
import co.edu.sena.security_app_2902093.persistence.entity.UserEntity;
import co.edu.sena.security_app_2902093.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SecurityApp2902093Application {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApp2902093Application.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository){
		return args ->{
			/*CREATE PERMISSIONS*/
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();


			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();

			PermissionEntity refactorPermission = PermissionEntity.builder()
					.name("REFACTOR")
					.build();

			/*Create ROLES*/
			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission,readPermission,updatePermission,deletePermission))
					.build();

			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionList(Set.of(createPermission,readPermission))
					.build();

			RoleEntity roleInvited = RoleEntity.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissionList(Set.of(readPermission))
					.build();

			RoleEntity roleDeveloper = RoleEntity.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissionList(Set.of(createPermission,readPermission,updatePermission,deletePermission,refactorPermission))
					.build();


			/*Create USERS*/
			UserEntity userMiguel = UserEntity.builder()
					.username("miguel")
					.password("$2a$10$yZri7zZGVeyIUbxNvPFxS.TH0tnv89ghMuiADZuHlOnF1XBgX..rW")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();

			UserEntity userAngel = UserEntity.builder()
					.username("angel")
					.password("$2a$10$c3OZMoTfE7ZaE4A2UBUgjeD/mm.kQEx/QTEtscoq1OGTnZGVzBCu6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();

			UserEntity userSamuel = UserEntity.builder()
					.username("samuel")
					.password("$2a$10$.8MvBNsQVMMkiPSzp7bvVeer.tUDO2LKL/N.tYk3CDwU8rk6Qa4.m")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleInvited))
					.build();

			UserEntity userDavid = UserEntity.builder()
					.username("David")
					.password("$2a$10$YH/yTs8R3JF2wo/l9BRo9O/nTB3ocmLAfiJBP7SxjdLqt0v9UpHue")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleDeveloper))
					.build();

			userRepository.saveAll(List.of(userMiguel,userAngel,userSamuel,userDavid));

		};
	}

}