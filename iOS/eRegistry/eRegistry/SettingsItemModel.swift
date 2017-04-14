//
//  SettingsItemModel.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 14.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import Foundation

enum SettingType {
    case password
    case phone
    case email
    case address
}

class SettingsItemModel {
    
    var image: UIImage = UIImage()
    var description: String = ""
    var type: SettingType = .password
    
    init(image: UIImage, description: String, type: SettingType) {
        self.image = image
        self.description = description
        self.type = type
    }
    
}
