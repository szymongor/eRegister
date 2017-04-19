//
//  MenuCVCell.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 13.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

class MenuCVCell: UICollectionViewCell {

    @IBOutlet weak var container: UIView! {
        didSet {
            container.backgroundColor = Colors.MAIN
        }
    }
    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var bottomView: UIView! {
        didSet {
            bottomView.backgroundColor = Colors.MAIN
        }
    }
    @IBOutlet weak var descriptionLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
    
    func setModel(_ model: MenuItemModel) {
        imageView.image = model.image
        descriptionLabel.text = model.description
        imageView.image = imageView.image?.withRenderingMode(.alwaysTemplate)
        imageView.tintColor = Colors.SECOND_APP_COLOR
    }

}
