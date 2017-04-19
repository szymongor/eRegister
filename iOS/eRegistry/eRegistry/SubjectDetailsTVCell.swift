//
//  SubjectDetailsTVCell.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 16.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

class SubjectDetailsTVCell: UITableViewCell {

    @IBOutlet weak var container: UIView! {
        didSet {
            container.backgroundColor = Colors.SECOND_APP_COLOR
            container.layer.cornerRadius = 8.0
            //container.layer.borderColor = Colors.SECOND_APP_COLOR.cgColor
            //container.layer.borderWidth = 0.5
        }
    }
    @IBOutlet weak var dateLabel: UILabel! {
        didSet {
            dateLabel.textColor = Colors.MAIN
        }
    }
    @IBOutlet weak var gradeLabel: UILabel! {
        didSet {
            gradeLabel.textColor = Colors.MAIN
        }
    }
    @IBOutlet weak var descriptionLabel: UILabel! {
        didSet {
            descriptionLabel.textColor = Colors.MAIN
        }
    }
    var grade: Grade?
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    func setView(for grade: Grade?) {
        
        self.grade = grade
        guard let gradeObj = grade else { return }
        dateLabel.text = gradeObj.date
        gradeLabel.text = "\(gradeObj.mark)"
        descriptionLabel.text = gradeObj.description
        
    }
    
}
