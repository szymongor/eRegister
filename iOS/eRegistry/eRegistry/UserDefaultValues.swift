//
//  UserDefaultValues.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 10.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import Foundation

enum UserType {
    case teacher
    case student
    case undefined
}

class User {
    fileprivate init() {}
    static let instance = User()
    
    var username: String {
        get {
            return UserDefaults.standard.string(forKey: "username") ?? ""
        }
        set {
            UserDefaults.standard.set(newValue, forKey: "username")
        }
    }
    
    var password: String {
        get {
            return UserDefaults.standard.string(forKey: "password") ?? ""
        }
        set {
            UserDefaults.standard.set(newValue, forKey: "password")
        }
    }
    
    var token: String {
        get {
            return UserDefaults.standard.string(forKey: "token") ?? ""
        }
        set {
            UserDefaults.standard.set(newValue, forKey: "token")
        }
    }
    
    var id: Int {
        get {
            return UserDefaults.standard.integer(forKey: "userId")
        }
        set {
            UserDefaults.standard.set(newValue, forKey: "userId")
        }
    }
    
    var roleName: String {
        get {
            let role = UserDefaults.standard.string(forKey: "role")
            if role == "TEACHER" { return "Nauczyciel" }
            else if role == "STUDENT" { return "Uczeń" }
            else { return "Niezdefiniowany" }
        }
        set {
            if newValue == "TEACHER" {
                roleType = .teacher
            } else if newValue == "STUDENT" {
                roleType = .student
            }

            UserDefaults.standard.set(newValue, forKey: "role")
        }
    }
    
    var mail: String {
        get {
            return UserDefaults.standard.string(forKey: "userMail") ?? "Brak adresu e-mail"
        }
        set {
            UserDefaults.standard.set(newValue, forKey: "userMail")
        }
    }
    
    var phone: String {
        get {
            return UserDefaults.standard.string(forKey: "userPhone") ?? "Brak numeru telefonu"
        }
        set {
            UserDefaults.standard.set(newValue, forKey: "userPhone")
        }
    }
    
    private(set) var roleType: UserType = .undefined
    
    var rememberMe: Bool {
        get {
            return UserDefaults.standard.bool(forKey: "rememberMe")
        }
        set {
            UserDefaults.standard.set(newValue, forKey: "rememberMe")
        }
    }
    
}
