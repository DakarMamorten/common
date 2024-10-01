//package com.wsh.domain;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//public class Staff {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long staffId;
//    private String firstName;
//    private String lastName;
//    @ManyToOne
//    @JoinColumn(name = "address_id")
//    private Address address;
//
//}
