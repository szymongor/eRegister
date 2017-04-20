//
//  UserDefaultValues.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 10.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import Foundation

enum UserRole {
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
    
    var roleName: String {
        get {
            return UserDefaults.standard.string(forKey: "role") ?? ""
        }
        set {
            if newValue == "ROLE_TEACHER" {
                roleType = .teacher
            } else if newValue == "ROLE_STUDENT" {
                roleType = .student
            }

            UserDefaults.standard.set(newValue, forKey: "role")
        }
    }
    
    private(set) var roleType: UserRole = .undefined
    
    var rememberMe: Bool {
        get {
            return UserDefaults.standard.bool(forKey: "rememberMe")
        }
        set {
            UserDefaults.standard.set(newValue, forKey: "rememberMe")
        }
    }
    
}
