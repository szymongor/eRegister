//
//  MenuItemModel.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 12.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import Foundation
import UIKit

enum MenuItemType {
    case grades
    case teacher
    case phone
    case address
    case email
}

class MenuItemModel {
    
    var image: UIImage = UIImage()
    var description: String = ""
    var type: MenuItemType = .phone
    
    init(image: UIImage, description: String, type: MenuItemType) {
        self.image = image
        self.description = description
        self.type = type
    }
    
}
