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
    
    static let MAIN = UIColor(red: 0.83, green: 0.22, blue: 0.22, alpha: 1)
    
    static func calculateColor(for value: CGFloat, fromInterval interval: [CGFloat], usingGradient gradient: [UIColor]) -> UIColor? {
        
        if interval.count != 2 {
            return gradient.first
        }
        
        guard let min = interval.first,
        let max = interval.last else {
                return gradient.last
        }
        
        if value > max {
            return gradient.last
        } else if value < min {
            return gradient.first
        }
        
        let intervalLength = max - min
        
        var peakValues: [CGFloat] = []
        let gradientCount = gradient.count
        
        for (index, color) in gradient.enumerated() {
            let temp = min + (CGFloat)(index)*(intervalLength/((CGFloat)(gradientCount-1)))
            peakValues.append(temp)
        }
        
        var colorIndexes: (Int, Int) = (0,0)
        
        for (index, peak) in peakValues.enumerated() {
            colorIndexes.0 = index - 1
            colorIndexes.1 = index
            if value < peak {
                break
            }
        }
        
        let firstColor = gradient[colorIndexes.0]
        let secondColor = gradient[colorIndexes.1]
        
        let firstTupple = UIColor.rgba(firstColor)()
        let secondTupple = UIColor.rgba(secondColor)()
        
        guard let red1 = firstTupple?.red,
            let red2 = secondTupple?.red,
            let green1 = firstTupple?.green,
            let green2 = secondTupple?.green,
            let blue1 = firstTupple?.blue,
            let blue2 = secondTupple?.blue else {
                return UIColor()
        }
        
        let lengthBetweenPeaks = peakValues[colorIndexes.1]-peakValues[colorIndexes.0]
        let percentValue = (value-peakValues[colorIndexes.0]) / lengthBetweenPeaks
        
        var red = 0, green = 0, blue = 0
        
        
        
        if red1 < red2 {
            if percentValue > 0.5 {
                red = red2 - Int(CGFloat(abs(red1 - red2))*percentValue)
            } else {
                red = red1 + Int(CGFloat(abs(red1 - red2))*percentValue)
            }
        } else {
            if percentValue > 0.5 {
                red = red2 + Int(CGFloat(abs(red2 - red1))*percentValue)
            } else {
                red = red1 - Int(CGFloat(abs(red2 - red1))*percentValue)
            }
        }
        let r: CGFloat = CGFloat(red)/CGFloat(255)
        
        if green1 < green2 {
            if percentValue > 0.5 {
                green = green2 - Int(CGFloat(abs(green1 - green2))*percentValue)
            } else {
                green = green1 + Int(CGFloat(abs(green1 - green2))*percentValue)
            }
        } else {
            if percentValue > 0.5 {
                green = green2 + Int(CGFloat(abs(green2 - green1))*percentValue)
            } else {
                green = green1 - Int(CGFloat(abs(green2 - green1))*percentValue)
            }
        }
        let g: CGFloat = CGFloat(green)/CGFloat(255)
        
        if blue1 < blue2 {
            if percentValue > 0.5 {
                blue = blue2 - Int(CGFloat(abs(blue1 - blue2))*percentValue)
            } else {
                blue = blue1 + Int(CGFloat(abs(blue1 - blue2))*percentValue)
            }
        } else {
            if percentValue > 0.5 {
                blue = blue2 + Int(CGFloat(abs(blue2 - blue1))*percentValue)
            } else {
                blue = blue1 - Int(CGFloat(abs(blue2 - blue1))*percentValue)
            }
        }
        let b: CGFloat = CGFloat(blue)/CGFloat(255)
        
        return UIColor.init(red: r, green: g, blue: b, alpha: 1)
    }
    
}
