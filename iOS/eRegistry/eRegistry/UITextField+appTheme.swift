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
    
    func appTheme() {
        self.borderStyle = .line
        self.layer.borderColor = Colors.MAIN.cgColor
    }
    
}
