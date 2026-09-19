import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemTooltip } from './item-tooltip';

describe('ItemTooltip', () => {
  let component: ItemTooltip;
  let fixture: ComponentFixture<ItemTooltip>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ItemTooltip],
    }).compileComponents();

    fixture = TestBed.createComponent(ItemTooltip);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
