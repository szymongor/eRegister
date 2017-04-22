//
//  ChildrenTVCell.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 20.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

class ChildrenTVCell: UITableViewCell {

    @IBOutlet weak var container: UIView! {
        didSet {
            container.appTheme()
        }
    }
    @IBOutlet weak var childName: UILabel! {
        didSet {
            childName.textColor = Colors.MAIN
        }
    }
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
    
    var student: Student!
    
    func prepare(for student: Student) {
        self.student = student
        childName.text = student.name + " " + student.surname
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
