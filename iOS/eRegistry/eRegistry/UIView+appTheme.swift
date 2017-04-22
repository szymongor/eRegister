//
//  UIView+appTheme.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 20.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import Foundation

extension UIView {
    
    func appTheme() {
        self.backgroundColor = Colors.SECOND_APP_COLOR
        self.layer.borderColor = Colors.SECOND_APP_COLOR.cgColor
        self.layer.borderWidth = 1.0
        self.layer.cornerRadius = 8.0
    }
    
}
