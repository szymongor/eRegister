//
//  UITextField+appTheme.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 10.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import Foundation
import UIKit

extension UITextField {
    
    override func appTheme() {
        self.layer.cornerRadius = 8.0
        self.borderStyle = .none
        self.layer.borderWidth = 1.0
        self.layer.borderColor = Colors.MAIN.cgColor
    }
    
}
