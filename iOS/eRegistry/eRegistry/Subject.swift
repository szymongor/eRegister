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
    var grades: [Grade] = []
    var averageGrade: CGFloat {
        get {
            var avg: CGFloat = 0
            for grade in grades {
                avg += grade.mark
            }
            return avg/CGFloat(grades.count)
        }
    }
    
    init(name: String, grades: [Grade]) {
        self.name = name
        self.grades = grades
    }
    
}
