package org.example.service;

import org.example.model.dtos.AddressDTO;
import org.example.model.dtos.PurchaseDTO;
import org.example.model.dtos.UserCreateDTO;
import org.example.model.dtos.UserSearchDTO;
import org.example.model.entities.Address;
import org.example.model.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private PurchaseMapper purchaseMapper;

    public UserMapper(PurchaseMapper purchaseMapper) {
        this.purchaseMapper = purchaseMapper;
    }

    public User mapUserDTOtoUserEntity(UserCreateDTO userCreateDTO) {
        User user = new User();
        user.setUsername(userCreateDTO.getUsername());
        user.setPassword(userCreateDTO.getPassword());
        user.setAge(userCreateDTO.getAge());
        user.setEmail(userCreateDTO.getEmail());
        user.setFirstName(userCreateDTO.getFirstName());
        user.setLastName(userCreateDTO.getLastName());
        user.setAddresses(userCreateDTO.getAddresses().stream().map(addressDTO -> {
            Address address = new Address();
            address.setId(addressDTO.getId());
            address.setCity(addressDTO.getCity());
            address.setFloorNo(addressDTO.getFloorNo());
        return address;
        }).collect(Collectors.toList()));
        return user;
    }

    public User mapUserSearchDTOtoUserEntity(UserSearchDTO userCreateDTO) {
        User user = new User();
        user.setUsername(userCreateDTO.getUsername());
        user.setPassword(userCreateDTO.getPassword());
        user.setAge(userCreateDTO.getAge());
        user.setEmail(userCreateDTO.getEmail());
        user.setFirstName(userCreateDTO.getFirstName());
        user.setLastName(userCreateDTO.getLastName());
        return user;
    }

    public UserCreateDTO mapUserEntityToUserDTO(User user) {
        return UserCreateDTO.builder().age(user.getAge()).email(user.getEmail())
                .username(user.getUsername()).firstName(user.getFirstName())
                .lastName(user.getLastName()).password(user.getPassword()).build();
    }

    public UserSearchDTO mapUserEntityToUserSearchDTO(User user) {
//        AddressDTO addressDTO = new AddressDTO();
//        if (Objects.nonNull(user.getAddress())) {
//            addressDTO.setId(user.getAddress().getId());
//            addressDTO.setCity(user.getAddress().getCity());
//            addressDTO.setFloorNo(user.getAddress().getFloorNo());
//            addressDTO.setStreetName(user.getAddress().getStreetName());
//        }
//



        List<AddressDTO> addressList = new ArrayList<>();
        if (Objects.nonNull(user.getAddresses()) && !user.getAddresses().isEmpty()) {
            addressList = user.getAddresses().stream().map(x->{
                    AddressDTO addressDTO1 = new AddressDTO();
                    addressDTO1.setId(x.getId());
                    addressDTO1.setFloorNo(x.getFloorNo());
                    addressDTO1.setStreetName(x.getStreetName());
                    return addressDTO1;
                }).collect(Collectors.toList());
        }

        List<PurchaseDTO> purchaseDTOS = new ArrayList<>();
        if (Objects.nonNull(user.getPurchases()) && !user.getPurchases().isEmpty()) {
            purchaseDTOS = user.getPurchases().stream().map(purchase -> purchaseMapper.mapPurchaseEntityToPurchaseDTO(purchase)).collect(Collectors.toList());
        }

        return UserSearchDTO.builder().id(user.getId()).age(user.getAge()).email(user.getEmail())
                .username(user.getUsername()).firstName(user.getFirstName())
                .lastName(user.getLastName()).password(user.getPassword())
                .address(addressList)
                .purchaseDTOs(purchaseDTOS)
                .build();
    }
}
