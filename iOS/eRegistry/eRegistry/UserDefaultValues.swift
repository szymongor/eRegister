//
//  UserDefaultValues.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 10.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import Foundation

class UserDefaultValues {
    
    static var username: String {
        get {
            return UserDefaults.standard.string(forKey: "username") ?? ""
        }
        set {
            UserDefaults.standard.set(newValue, forKey: "username")
        }
    }
    
    static var password: String {
        get {
            return UserDefaults.standard.string(forKey: "password") ?? ""
        }
        set {
            UserDefaults.standard.set(newValue, forKey: "password")
        }
    }
    
    static var token: String {
        get {
            return UserDefaults.standard.string(forKey: "token") ?? ""
        }
        set {
            UserDefaults.standard.set(newValue, forKey: "token")
        }
    }
    
    static var role: String {
        get {
            return UserDefaults.standard.string(forKey: "role") ?? ""
        }
        set {
            var value = ""
            if newValue == "ROLE_TEACHER" {
                value = "Nauczyciel"
            } else if newValue == "ROLE_STUDENT" {
                value = "Uczeń"
            }
            UserDefaults.standard.set(value, forKey: "role")
        }
    }
    
    static var rememberMe: Bool {
        get {
            return UserDefaults.standard.bool(forKey: "rememberMe") 
        }
        set {
            UserDefaults.standard.set(newValue, forKey: "rememberMe")
        }
    }
    
}
