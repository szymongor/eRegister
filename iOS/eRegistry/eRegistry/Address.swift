//
//  Address.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 25.06.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit
class Address {
    
    var city: String = ""
    var country: String = ""
    var postalCode: String = ""
    var street: String = ""
    var houseNumber: String = ""
    var flatNumber: String?
    
    init(country: String, city: String, postalCode: String, street: String, houseNumber: String, flatNumber: String?) {
        self.country = country
        self.city = city
        self.postalCode = postalCode
        self.street = street
        self.houseNumber = houseNumber
        self.flatNumber = flatNumber
    }
    
}
