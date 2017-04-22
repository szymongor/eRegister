//
//  Student.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 20.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import Foundation

class Student {
    
    var id: Int = 0
    var name: String = ""
    var surname: String = ""
    
    init(id: Int, name: String, surname: String) {
        self.id = id
        self.name = name
        self.surname = surname
    }
    
}
