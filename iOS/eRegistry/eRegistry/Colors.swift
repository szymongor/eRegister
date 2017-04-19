//
//  Colors.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 10.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import Foundation
import UIKit

class Colors {
    
    //MARK: - Constants
    
    static let MAIN = UIColor(red: 0.83, green: 0.22, blue: 0.22, alpha: 1)
    static let SECOND_APP_COLOR = UIColor.white
    

    //MARK: - Functions
    
    static func getColor(forGrade grade: CGFloat) -> UIColor {
        
        // grades points set up
        let lowGrade: CGFloat = 2
        let mediumGrade: CGFloat = 4
        let goodGrade: CGFloat = 6
        
        // check if grade is between min and max
        if grade > goodGrade {
            return UIColor.green
        } else if grade < lowGrade {
            return UIColor.red
        }
        
        // init colors
        var red: CGFloat = 0
        var green: CGFloat = 0
        let blue: CGFloat = 0
        let alpha: CGFloat = 1
        
        // calculate color for grade
        if grade < mediumGrade { // bad grade
            let interval = mediumGrade - lowGrade
            let percentValue = (grade - lowGrade)/interval
            
            red = 1
            green = percentValue
        } else { // good grade
            let interval = goodGrade - mediumGrade
            let percentValue = (goodGrade - grade)/interval
            
            red = percentValue
            green = 1
        }
        
        return UIColor.init(red: red, green: green, blue: blue, alpha: alpha)
        
    }
    
    
}
