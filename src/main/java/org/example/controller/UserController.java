package org.example.controller;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.example.model.CustomResponseDTO;
import org.example.model.User;
import org.example.model.dtos.UserCreateDTO;
import org.example.model.dtos.UserSearchDTO;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

// curs 24.10.2023
//@Controller
@RestController   // - returneaza si un body in plus fata de Controller
@RequestMapping(path = "/api/v1")
public class UserController {

    // metoda care sa returneze toti user-ii din baza de data cu numele...
    // cumva ofera posibilitatea de a sorta user-ii dupa nume

    // se creaza un obiect al clasei userService
    private final UserService userService;


    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

   // @GetMapping("/getUsersByFirstName") // Get se foloseste la citirea datelor

   // public List<User> getUsersByFirstName(@RequestParam(required = false) String firstName){
        // @RequestParam permite user-ului sa introduca si parametrul firstName pe langa URL
                                                                            // ?firstName=value
                                                                            // required=false - nu e cerut in call'

    // curs 31.10
    // @RequestBody = face deserializare automat; adica mapeaza din JSON in obiect Java
    // modificare curs 02.11 -> se modifica tipul returnat din CustomResponseDTO in ResponseIdentity<CustomResponseDTO> pentru
    // a putea seta un anumit HttpStatus (in acest caz va fi CREATED)
   // @PostMapping(path = "/user") // Post creaza resurse noi
   // public /*User*/ ResponseEntity<org.example.model.entities.User> createNewUser(@RequestBody @Valid UserCreateDTO userCreateDTO, BindingResult bindingResult){  //@Valid impune ca obiectul sa fie validat conform anotarilor de validare din clasa User
        //System.out.println(user);
        //System.out.println(user.getEmail().toString());     // se face un apel pentru crearea unui user si se returneaza acesta pentru a vedea ceea ce s-a creat in spate

        // cu BindingResult se fac diverse verificari

//        CustomResponseDTO customResponseDTO = new CustomResponseDTO();
//        if(bindingResult.hasErrors()){
//            // se verifica daca exista erori, se salveaza in String-ul message, apoi se apeleaza cu ajutorul obiectului CustomResponseDTO
//
//            // bindingResult.getFieldErrors() -> returneaza o lista de FieldErrors -> se face un stream pentru mapare pentru ca avem nevoie doar de
//                                            // default message din acele erori
//             String message = bindingResult.getFieldErrors().get(0).getDefaultMessage();
//              customResponseDTO.setResponseObject(null); // -> raspunsul este null daca apare o eroare
//              customResponseDTO.setResponseMessage(message);
//              return new ResponseEntity<>(customResponseDTO, HttpStatus.BAD_REQUEST);
//        } else {
//
//            customResponseDTO.setResponseObject(user);
//            userList.add(user);
//            customResponseDTO.setResponseMessage("User created successfully");     // daca nu sunt erori, se returneaza user-ul create si mesajul acesta
//           return new ResponseEntity<>(customResponseDTO, HttpStatus.CREATED);
         //   return new ResponseEntity(userService.createUser(userCreateDTO), HttpStatus.CREATED);
       // }
  //  }

    //->QueryParam ?firstName=alex
//    public List<User> getUsersByFirstName(@PathVariable String firstName){  // -> Path param ../23 (unde 23 este id-ul)
//        // controller-ul trebuie sa faca maparea pentru a apela metoda din Service
//        // nu trebuie sa exista logica in controller
//        // se apeleaza metoda getUSersByFirstName din UserService
//        return userService.findUsersByFirstName(String firstName);
//   }

    // 16 noiembrie
    @GetMapping("/getUsersByFirstName/{firstName}")
    public ResponseEntity<CustomResponseDTO> getUsersByFirstName(@PathVariable String firstName){
        ResponseEntity responseEntity;
        CustomResponseDTO customResponseDTO = new CustomResponseDTO();
        List<UserSearchDTO> foundUsers = userService.findUsersByFirstName(firstName);
        if(Objects.isNull(foundUsers) || foundUsers.isEmpty()){
            customResponseDTO.setResponseMessage("No user was found bi this first name.");
            return new ResponseEntity<>(customResponseDTO, HttpStatus.NOT_FOUND);
        }
        customResponseDTO.setResponseObject(foundUsers);
        customResponseDTO.setResponseMessage("User found successfully!");
        return new ResponseEntity<>(customResponseDTO, HttpStatus.OK);
    }
}