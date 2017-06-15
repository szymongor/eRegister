//
//  Grade.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 16.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import Foundation

class Grade {
    
    var id: Int = 0
    var mark: CGFloat = 0
    var description: String = ""
    var date: String = ""
    var subjectName: String = ""
    
    init(mark: CGFloat, date: String, description: String) {
        self.mark = mark
        self.date = date
        self.description = description
    }
    
    init(usingJson json: JSONStandard) {
        if let id = json["id"] as? Int {
            self.id = id
        }
        if let markString = json["mark"] as? String {
            if let markNumber = NumberFormatter().number(from: markString) {
                self.mark = CGFloat(markNumber)
            }
        }
        if let description = json["description"] as? String {
            self.description = description
        }
        if let date = json["date"] as? String {
            self.date = date
        }
        if let subjectName = json["subjectName"] as? String {
            self.subjectName = subjectName
        }
    }
    
}
