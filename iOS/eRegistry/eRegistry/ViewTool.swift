//
//  ViewTool.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 16.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import Foundation

class ViewTool {
    
    static func addShadow(to view: UIView) {
        
        view.layer.shadowColor = UIColor.black.cgColor
        view.layer.shadowOffset = CGSize(width: 5, height: 5)
        view.layer.shadowRadius = 5
        view.layer.shouldRasterize = false
        view.layer.shadowOpacity = 0.8
        view.layer.masksToBounds = false
        
    }
    
    static func removeShadow(from view: UIView) {
        
        view.layer.shadowColor = UIColor.clear.cgColor
        
    }
    
}
