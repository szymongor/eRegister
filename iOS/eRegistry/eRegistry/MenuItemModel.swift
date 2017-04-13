//
//  MenuItemModel.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 12.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import Foundation
import UIKit

class MenuItemModel {
    
    var image: UIImage = UIImage()
    var description: String = ""
    
    init(with image: UIImage, _ description: String) {
        self.image = image
        self.description = description
    }
    
}
