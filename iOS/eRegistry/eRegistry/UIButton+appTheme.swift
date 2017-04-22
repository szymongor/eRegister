//
//  UIButton+appTheme.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 10.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import Foundation
import UIKit

extension UIButton {
    
    override func appTheme() {
        
        self.layer.cornerRadius = 8.0
        self.backgroundColor = Colors.MAIN
        self.setTitleColor(Colors.SECOND_APP_COLOR, for: .normal)
        
    }
    
}
