//
//  Subject.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 14.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import Foundation

class Subject {
    
    var name: String = ""
    var averageGrade: CGFloat = 1
    
    init(name: String, averageGrade: CGFloat) {
        self.name = name
        self.averageGrade = averageGrade
    }
    
}
