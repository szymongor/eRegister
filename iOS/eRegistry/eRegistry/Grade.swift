//
//  Grade.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 16.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import Foundation

class Grade {
    
    var mark: CGFloat = 0
    var date: String = ""
    var description: String = ""
    
    init(mark: CGFloat, date: String, description: String) {
        self.mark = mark
        self.date = date
        self.description = description
    }
    
}
