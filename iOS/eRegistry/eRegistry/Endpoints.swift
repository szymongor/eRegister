//
//  Endpoints.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 25.05.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import Foundation

class Endpoints {
    static let auth = "auth"
    static let lessons = "Lessons"
    static let lessonsById = "Lessons/student/lessons/userId="
    static let newPassword = "EregUsers/newPassword"
    static let newPhone = "People/updatePhone"
    static let newMail = "People/updateMail"
    static let grades = "Grades/userPartialGrades"
    static let personById = "People/Person/id="
    static let addressById = "People/Address/id="
    static let personalData = "myPersonalData"
    static let child = "People/myChildren"
    static let myClass = "/Groups/myClass"
}
