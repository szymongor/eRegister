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
    var id: Int = 0
    var teacherName = ""
    var teacherSurname = ""
    var grades: [Grade] = []
    var averageGrade: CGFloat {
        get {
            var avg: CGFloat = 0
            if grades.isEmpty {
                return 0
            }
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
    
    init(usingJson json: JSONStandard) {
        if let name = json["subjectName"] as? String {
            self.name = name
        }
        if let id = json["id"] as? Int {
            self.id = id
        }
        if let teacherName = json["teacherName"] as? String {
            self.teacherName = teacherName
        }
        if let teacherSurname = json["teacherSurname"] as? String {
            self.teacherSurname = teacherSurname
        }
    }
    
}
